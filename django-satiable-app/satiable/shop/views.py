from django.shortcuts import render, get_object_or_404
from django.http import HttpResponse, Http404
from .models import Item


# Create your views here.
def index(request):
    """The index page for shop"""
    latest_item_list = Item.objects.order_by('-pub_date')[:5]
    context = {'latest_item_list': latest_item_list}
    return render(request, 'shop/index.html', context)


def detail(request, item_id):
    item = get_object_or_404(Item, pk=item_id)
    context = {'item': item}
    return render(request, 'shop/detail.html', context)


def purchase(request, item_id):
    item = get_object_or_404(Item, pk=item_id)
    if not item.is_available():
        return Http404("Item is not available for purchase")
    context = {'item': item}
    return render(request, 'shop/purchase.html', context)
