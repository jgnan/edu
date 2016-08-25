# coding = utf-8
class ImagesController < ApplicationController
  before_action :set_image, only: [:show, :edit, :update, :destroy]
  before_action :set_scope

  
  # GET /images
  # GET /images.json
  def index
    @search = search_params
    #do your customize query here
    @images = Image.page(params[:page]).order('created_at desc')
    if @search && @search[:keyword]
      @images = @images.where('title like ?', @search[:keyword]+'%')
    end
  end
  
  # GET /images/1
  # GET /images/1.json
  def show
  end

  # GET /images/new
  def new
    @image = Image.new
  end


  # GET /images/1/edit
  def edit
  end

  # POST /images
  # POST /images.json
  def create
    @image = Image.new(image_params)


    if @image.save
      redirect_to @image, notice: "Image记录 #{@image.id} 创建成功!"
    else
      render action: 'new'
    end
  end

  # PATCH/PUT /images/1
  # PATCH/PUT /images/1.json
  def update
    if @image.update(image_params)
       redirect_to @image, notice: "Image记录 #{@image.id} 更新成功!"
    else
      render action: 'edit'
    end
  end

  
   

  # DELETE /images/1
  # DELETE /images/1.json
  def destroy
    @image.destroy
    redirect_to images_url, notice: 'Image记录删除成功'
  end

  # DELETE /images/delete/all
  def destroy_all
    if params[:images]
      Image.delete_all(:id => params[:images])
      redirect_to images_url, :notice => "Image记录删除成功"
    else
      redirect_to images_url, :alert => "请选择要删除的Image记录"
    end
  end

    
    

  private
  # set the menu scope variable
  def set_scope
    @scope = 'images'
  end

  #authroize scope privilege
  def authorize_image_scope
    authorize Image, :index?
  end

  # Use callbacks to share common setup or constraints between actions.
  def set_image
    @image = Image.find(params[:id])
  end

  # Never trust parameters from the scary internet, only allow the white list through.
  def image_params
    params.require(:image).permit(:title, :url,:total_size)
  end

  def search_params
    params[:search] || {}
  end
end
