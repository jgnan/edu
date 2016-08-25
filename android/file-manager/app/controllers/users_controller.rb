class UsersController < ApplicationController
  before_action :set_user, only: [:show, :edit, :update, :destroy, :save_roles]

  def set_scope
    @scope = %w(users users)
  end

  # Current user information
  # GET /users/current
  def current_user
    @user = current_user
  end

  # POST /users/current
  def save_current_user
    if current_user.update(user_params)
      redirect_to :current_user, notice: '用户信息更新成功.' 
    else
      render :current_user
    end
  end

  # GET /users
  # GET /users.json
  def index
    @search = search_params
    @users = User.page(params[:page]).order('created_at desc')
    unless @search[:keyword].nil?
      @users = @users.where('account like ? or email like ? or mobile like ?',"#{@search[:keyword]}%","#{@search[:keyword]}%","#{@search[:keyword]}%" )
    end
  end

  # GET /users/1
  # GET /users/1.json
  def show
    @roles = UserRole.all
  end

  # GET /users/new
  def new
    @user = User.new
  end

  # GET /users/1/edit
  def edit
  end

  # POST /users
  # POST /users.json
  def create
    @user = User.new(user_params)
    @user.roles = []
    @user.password= Rails.application.config.x.default_secret

    respond_to do |format|
      if @user.save
        format.html { redirect_to @user, notice: '用户创建成功.' }
        format.json { render :show, status: :created, location: @user }
      else
        format.html { render :new }
        format.json { render json: @user.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /users/1
  # PATCH/PUT /users/1.json
  def update
    respond_to do |format|
      if @user.update(user_params)
        format.html { redirect_to @user, notice: '用户信息更新成功.' }
        format.json { render :show, status: :ok, location: @user }
      else
        format.html { render :edit }
        format.json { render json: @user.errors, status: :unprocessable_entity }
      end
    end
  end

  # POST /users/1/roles
  def save_roles
    @user.roles = params[:roles].nil? ? [] : params[:roles]
    if @user.save
      redirect_to @user, notice: '角色保存成功.'
    else
      render :show
    end
  end

  # DELETE /users/1
  # DELETE /users/1.json
  def destroy
    @user.destroy
    respond_to do |format|
      format.html { redirect_to users_url, notice: '用户删除成功.' }
      format.json { head :no_content }
    end
  end

  private
  # Use callbacks to share common setup or constraints between actions.
  def set_user
    @user = User.find(params[:id])
  end

  def search_params
    @search = params[:search] || {}
  end

  # Never trust parameters from the scary internet, only allow the white list through.
  def user_params
    params.require(:user).permit(:account, :name)
  end
end
