import datetime
from django.db import models
from django.utils import timezone
# Create your models here.


class Item(models.Model):
    """An item is something that can be or was for sale in the shop."""
    title = models.CharField(max_length=140)
    description = models.CharField(max_length=400)
    # featured_img = models.CharField(max_length=200)
    price = models.IntegerField()  # TODO: Let this take on decimal values
    num_available = models.IntegerField()  # Number of available copies
    num_purchased = models.IntegerField(default=0)  # Number of copies that have been sold
    pub_date = models.DateTimeField('date published')

    def __str__(self):
        return self.title

    def is_available(self):
        return self.num_available > 0 and self.pub_date <= timezone.now()

    def was_published_recently(self):
        return self.is_available() and self.pub_date >= timezone.now() - datetime.timedelta(days=5)

    def purchase(self):
        if self.is_available():
            self.num_available -= 1
            self.num_purchased += 1
        return


class ItemImage(models.Model):
    """An ItemImage is a picture of a particular item. There can be many pictures of a single item."""
    item = models.ForeignKey(Item, on_delete=models.CASCADE)
    alt_text = models.CharField(max_length=100)
    img_path = models.CharField(max_length=200)

    def __str__(self):
        return self.alt_text

