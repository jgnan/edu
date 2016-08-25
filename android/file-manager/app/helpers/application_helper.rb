module ApplicationHelper
  def record_name record
    val(record,:title) || val(record,:name) || val(record,:code) || val(record,:id) || ''
  end

  def val obj, field
    obj.respond_to?(field) and obj[field]
  end

  # Enabled and Disabled display name translate method
  def enabled_disabled_map status, default=nil
    map = {enabled: '可用', disabled: '不可用'}
    if  !status.nil? 
      map[to_sym(status)]
    elsif default.nil? 
      map
    else 
      map[default]
    end
  end

  # Syncope a string replacing with other characters
  def syncope str, opts={}
    if str.empty? 
      str
    else
      len = str.length
      opts.reverse_merge!({head: 5, tail: 0, char: '*', char_count:10})
      head = [opts[:head], len].min
      tail = opts[:tail]
      if(head + tail >= len)
       str 
      else
        "#{str[0,head]}#{opts[:char]*[opts[:char_count],len - head - tail].min}#{str[len-tail,tail]}"
      end
    end
  end

  def to_sym val
    if val.nil?
      nil
    else 
      val.respond_to?(:to_sym) ? val.to_sym : val.to_s.to_sym
    end
  end

  # Generate enable item for record has a status value
  def enable_button *records
    status_change_button records,:enabled, :disable, '停用'
  end


  # Generate disable item for record has a status value
  def disable_button *records
    status_change_button records,:disabled, :enable, '启用'
  end

  # Private method to generate status change button
  def status_change_button records, status,action, label
    val = records.is_a?(Array) ? records.last : records
    if val.respond_to?(:status) and val.status == status.to_s
      link_to label, polymorphic_path(records,action: to_sym(action)), method: :put, class: 'btn btn-info'
    end
  end

  def get context, *paths
    if context.nil?
      return options[:default]
    end
  end


  # Find first not nil item in an array
  def first_not_nil *arr
    arr.find {|x| !x.nil? and !x.blank?}
  end

  # Get value base on a object and through a specific part
  def get_val(obj,*fields)
    options = fields.extract_options!()
    default = options[:default]
    return default unless obj && fields
    result = fields.reduce(obj) do |result,field|
      return default if result.nil? or field.nil?
      # if the value not exists, it'll be nil
      if result.respond_to?(:reflections) and result.reflections[field]
        assoc = result.association(field)
        # if no association record, then return default value directly
        return ni unless assoc
        # load it first before get the value. Association method would not load value.
        assoc.reload unless assoc.loaded?
        result = assoc.target
        next result
      end
      # try on hash
      if result.respond_to?(:has_key?) and is_include?(result, field)
        to_checks = [field,field.to_s]
        to_checks << field.to_sym if field.respond_to? :to_sym
        to_checks.each do |k|
          next unless result.has_key?(k)
          result = result[k]
          break
        end
        next result
      end
      # try on array 
      if result.is_a?(Array) and field.is_a?(Fixnum)
        if result.size > field
          # for hash and array, we can use field as index
          result = result[field]
          next result
        else
          # an empty array need not to recurse any more
          return default
        end
      end

      # then try on object
      if is_respond_to? result, field
        val = result[field]
        # try to call a method
        unless val
          begin
            val = result.method(field).call
          rescue
          end
        end
        next val
      end

      # for collections
      if result.respond_to? :each and !result.respond_to? :has_key?
        results = []
        result.each do |record|
          new_fields = fields.drop_while {|path| path != field}
          results << get_val(record,*new_fields, options)
        end
        return results
      end

      # none of the above condition met, return default value instead
      return default
    end
    # data type handling
    type = options[:type]
    return result unless type

    case type
    when :datetime
      Time.zone.parse(result.to_s) unless result.nil?
    end
  end

  # Check whether key in object, no metter what type the object is.
  # It also help to try every possible forms of the key, including, the original form,
  # String form or symbo form.
  def is_include? obj, key
    return false unless obj and obj.respond_to? :[]
    return true if key.nil? and obj[key] # one very special case is nil using as key
    is_fixnum = key.is_a? Fixnum
    if obj.respond_to?(:include?)
      checks = [key,key.to_s]
      checks << key.to_sym if key.respond_to?(:to_sym)
      checks.each do |k|
        return true if obj.include? k
      end
      false
    elsif is_fixnum and obj.respond_to? :size
      obj.size > key
    elsif is_fixnum and obj.respond_to? :count
      obj.count > key
    else
      false
    end 
  end 

  def is_respond_to? obj,field
    return false unless obj and field.respond_to? :to_sym
    obj.respond_to? field.to_sym
  end

  def format_date(date, format='%Y/%m/%d')
    date.strftime(format) if date
  end

  def format_datetime(datetime, format='%Y/%m/%d %H:%M')
    datetime.strftime(format) if datetime
  end

  def active_scope?(key, lv=0)
    scope = @scope.length ? @scope[lv] : @scope
    scope == key
  end
end
