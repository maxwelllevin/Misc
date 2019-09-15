from django.urls import path

from . import views

app_name = 'shop'
urlpatterns = [
    path('shop/', views.index, name='index'),
    path('shop/<int:item_id>/', views.detail, name='detail'),
    path('shop/<int:item_id>/purchase', views.purchase, name='purchase'),
]
