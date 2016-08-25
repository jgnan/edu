module PunditHelper
  # check whether user has specific roles (any)
  def has_roles? *roles
    !(user.nil? || user.roles.nil?  || (roles.collect {|r| r.to_s} & user.roles).empty?)
  end

  def role_own? role
    has_roles?(:super_admin) || (has_roles?(role) and user.owner_of?(record))
  end
end
