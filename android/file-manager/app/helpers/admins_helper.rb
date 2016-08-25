module AdminsHelper
  def admin_name record
    record.account || record.id
  end
end
