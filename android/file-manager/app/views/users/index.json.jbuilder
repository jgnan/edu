json.array!(@users) do |user|
  json.extract! user, :id, :account
  json.url user_url(user, format: :json)
end
