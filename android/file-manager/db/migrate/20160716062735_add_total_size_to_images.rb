class AddTotalSizeToImages < ActiveRecord::Migration
  def change
    add_column :images, :total_size, :integer, default: 0
  end
end
