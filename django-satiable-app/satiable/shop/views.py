from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
def index(request):
    """The index page for shop"""
    return HttpResponse("Hello world, this is the satiable landing page.")
