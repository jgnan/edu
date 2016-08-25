module MenuHelper
  def menu &block
    <<-HTML.html_safe
    <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
        #{capture(&block)}
        </ul>
      </div>
    </div>
    HTML
  end

  def item *fields, &block
    opts = fields.extract_options!
    url = block_given? ? 'javascript:void(0)' : fields[0]
    icon = opts[:icon] ? "fa fa-#{opts[:icon]} fa-fw" : ''
    title = block_given? ? fields[0] : fields[1]
    scope = opts[:scope]
    is_active = active_scope? scope, 0
    submenu = if block_given?
       <<-SUBMENU
       <ul class="nav nav-second-level" aria-expanded="#{is_active}">
         #{capture(&block) if block_given?}
       </ul>
       SUBMENU
    else 
      ''
    end

    <<-HTML.html_safe
    <li #{'class="active"' if is_active}>
      <a href="#{url}" aria-expanded="#{is_active}"><i class="#{icon}"></i> #{title}<span class="fa arrow"></span></a>
      #{submenu}
    </li>
    HTML
  end

  def subitem *fields
    opts = fields.extract_options!
    url = fields[1]
    title = fields[0]
    scope = opts[:scope]
    is_active = active_scope? scope, 1
    <<-HTML.html_safe
      <li>
        <a href="#{url}" #{'class="active"' if is_active}>#{title}</a>
      </li>
    HTML
  end
end
