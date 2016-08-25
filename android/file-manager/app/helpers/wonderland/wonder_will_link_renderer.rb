require 'will_paginate/view_helpers/link_renderer'

module Wonderland
  class  WonderWillLinkRenderer < WillPaginate::ActionView::LinkRenderer
    def page_number(page)
      unless page == current_page
        tag(:li,link(page,page, rel: rel_value(page)).html_safe)
      else
        tag(:li,page,class: 'active')
      end
    end

    def to_html
      html = pagination.map do |item|
        item.is_a?(Fixnum) ? page_number(item) : send(item)
      end.join(@options[:link_separator])

      @options[:container] ? html_container(html) : html
      html
    end

    protected
    def page_number(page)
      unless page == current_page
        tag(:li,link(page, page, :rel => rel_value(page)).html_safe)
      else
        tag(:li, link(page,page), :class => 'active')
      end
    end

    def rel_value(page)
      case page
        when @collection.current_page - 1; 'prev' + (page == 1 ? ' start' : '')
        when @collection.current_page + 1; 'next'
        when 1; 'start'
      end
    end

    def gap
      tag("li", tag("span", '...'), class: "disabled")
    end

    def previous_or_next_page(page, text, classname)
      link_options = @options[:link_options] || {}

      if page
        tag("li", link(text, page, link_options), class: classname)
      else
        tag("li", tag("span", text), class: "%s disabled" % classname)
      end
    end

  end
end

