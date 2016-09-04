class CreateUserAccounts < ActiveRecord::Migration
  def change
    create_table :user_accounts do |t|
      t.integer :user_id
      t.decimal :account_balance, precision: 10, scale:2
      t.string :status

      t.timestamps null: false
      t.index :user_id
    end
  end
end
