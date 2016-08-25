Rails.application.routes.draw do
  resources :images
  devise_for :users, controllers: {
    sessions: 'users/sessions'
  }
  resources :users
  root 'users#index'
end
