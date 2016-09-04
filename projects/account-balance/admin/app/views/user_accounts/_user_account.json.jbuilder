json.extract! user_account, :id, :user_id, :account_balance, :status, :created_at, :updated_at
json.url user_account_url(user_account, format: :json)