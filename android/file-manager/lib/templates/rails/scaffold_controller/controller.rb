# coding = utf-8
<% module_namespacing do -%>
class <%= controller_class_name %>Controller < ApplicationController
  before_action :set_<%=singular_table_name %>, only: [:show, :edit, :update, :destroy<%if attributes.find {|a| a.name == 'status'}%>,:update_status<%end%><%if attributes.find {|a| a.name == "#{singular_table_name}_key"}%>,:refresh_key<%end%>]
  before_action :authorize_<%=singular_table_name%>_scope

  
  # GET <%= route_url %>
  # GET <%= route_url %>.json
  def index
    @search = search_params
    #do your customize query here
    @<%= plural_table_name %> = <%=class_name%>.page(params[:page]).order('created_at desc')
  end
  
  # GET <%= route_url %>/1
  # GET <%= route_url %>/1.json
  def show
  end

  # GET <%= route_url %>/new
  def new
    @<%= singular_table_name %> = <%= orm_class.build(class_name) %>
  end


  # GET <%= route_url %>/1/edit
  def edit
  end

  # POST <%= route_url %>
  # POST <%= route_url %>.json
  def create
    @<%= singular_table_name %> = <%=orm_class.build(class_name, "#{singular_table_name}_params") %>
<% attributes.each do |attr| %><% if attr.name == 'status' -%>
    @<%=singular_table_name%>.status = :enabled
<% elsif attr.name == "#{singular_table_name}_key" -%>
    @<%=singular_table_name%>.<%=singular_table_name%>_key = SecureRandom.hex(32)
<% end %><% end -%>


    if @<%= orm_instance.save %>
      redirect_to @<%=singular_table_name%>, notice: "<%=class_name%>记录 #{@<%=singular_table_name%>.id} 创建成功!"
    else
      render action: 'new'
    end
  end

  # PATCH/PUT <%= route_url %>/1
  # PATCH/PUT <%= route_url %>/1.json
  def update
    if @<%= orm_instance.update("#{singular_table_name}_params") %>
       redirect_to @<%=singular_table_name%>, notice: "<%=class_name%>记录 #{@<%=singular_table_name%>.id} 更新成功!"
    else
      render action: 'edit'
    end
  end

  <% if attributes.find {|a| a.name == 'status'} %>
  # PUT <%= route_url%>/id/enabled
  # PUT <%= route_url%>/id/disabled
  def update_status
    @<%=singular_table_name%>.status = params[:status] || :disabled
    respond_to do |format|
      if @<%=singular_table_name%>.save
        format.html { redirect_to @<%=singular_table_name%>, notice: '<%=class_name%>记录更新成功' }
        format.json { render :show, status: :ok, location: @<%=singular_table_name%> }
      else
        format.html { render :show }
        format.json { render json: @<%=singular_table_name%>.errors, status: :unprocessable_entity }
      end
    end
  end
  <% end -%>

  <% if attributes.find {|a| a.name == "#{singular_table_name}_key"} %>
  # PUT <%= route_url%>/id/refresh_key/
  def refresh_key
    @<%=singular_table_name%>.<%=singular_table_name%>_key = SecureRandom.hex(32)
    respond_to do |format|
      if @<%=singular_table_name%>.save
                      format.html { redirect_to @<%=singular_table_name%>, notice: '<%=class_name%>密钥已刷新' }
        format.json { render :show, status: :ok, location: @<%=singular_table_name%> }
      else
        format.html { render :show }
        format.json { render json: @<%=singular_table_name%>.errors, status: :unprocessable_entity }
      end
    end
  end
  <% end -%> 

  # DELETE <%= route_url %>/1
  # DELETE <%= route_url %>/1.json
  def destroy
    @<%= orm_instance.destroy %>
    redirect_to <%=index_helper%>_url, notice: '<%=class_name%>记录删除成功'
  end

  # DELETE <%= route_url %>/delete/all
  def destroy_all
    if params[:<%=plural_name%>]
      <%=class_name%>.delete_all(:id => params[:<%=plural_name%>])
      redirect_to <%= index_helper %>_url, :notice => "<%=class_name%>记录删除成功"
    else
      redirect_to <%= index_helper %>_url, :alert => "请选择要删除的<%=class_name%>记录"
    end
  end

  <% if attributes.find {|a| a.name == 'status'} %>
    # PUT <%= route_url%>/id/enabled
    # PUT <%= route_url%>/id/disabled
    def update_status
      @<%=singular_table_name%>.status = params[:status] || :disabled
      respond_to do |format|
        if @<%=singular_table_name%>.save
          format.html { redirect_to @<%=singular_table_name%>, notice: '<%=class_name%>记录更新成功' }
          format.json { render :show, status: :ok, location: @<%=singular_table_name%> }
        else
          format.html { render :show }
          format.json { render json: @<%=singular_table_name%>.errors, status: :unprocessable_entity }
        end
      end
    end
    <% end -%>
  
    <% if attributes.find {|a| a.name == "#{singular_table_name}_key"} %>
    # PUT <%= route_url%>/id/refresh_key/
    def refresh_key
      @<%=singular_table_name%>.<%=singular_table_name%>_key = SecureRandom.hex(32)
      respond_to do |format|
        if @<%=singular_table_name%>.save
                        format.html { redirect_to @<%=singular_table_name%>, notice: '<%=class_name%>密钥已刷新' }
          format.json { render :show, status: :ok, location: @<%=singular_table_name%> }
        else
          format.html { render :show }
          format.json { render json: @<%=singular_table_name%>.errors, status: :unprocessable_entity }
        end
      end
    end
    <% end -%>


  private
  # set the menu scope variable
  def set_scope
    @scope = '<%=plural_table_name%>'
  end

  #authroize scope privilege
  def authorize_<%=singular_table_name%>_scope
    authorize <%= class_name%>, :index?
  end

  # Use callbacks to share common setup or constraints between actions.
  def set_<%= singular_table_name %>
    @<%= singular_table_name %> = <%= orm_class.find(class_name, "params[:id]") %>
  end

  # Never trust parameters from the scary internet, only allow the white list through.
  def <%= singular_table_name%>_params
    <%- if attributes_names.empty? -%>
    params[:<%= singular_table_name%>]
    <%- else -%>
    params.require(:<%= singular_table_name %>).permit(<%= attributes_names.map{ |name| ":#{name}" }.join(', ') %>)
    <%- end -%>
  end

  def search_params
    params[:search] || {}
  end
end
<% end -%>
