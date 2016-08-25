json.array!(@images) do |image|
  json.extract! image, :id, :title, :url,:total_size
  json.url image_url(image, format: :json)
end
