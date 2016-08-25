module MerchantsHelper
  def merchant_select form, field=:merchant_id
    form.select field, Merchant.where(status: :enabled).collect {|m| [m.name,m.id]},{include_blank: '无'},class:'form-control'
  end

  def merchant_name merchant
    merchant.nil? ? '' : merchant.name || merchant.id
  end
end
