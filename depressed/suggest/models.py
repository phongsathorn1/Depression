from django.db import models
from django.core.validators import MaxValueValidator, MinValueValidator

# Create your models here.


class Suggestion(models.Model):
    depressed_level = models.CharField(max_length=100, default='null')
    text = models.CharField(max_length=500, default='null')

    def __unicode__(self):
        return self.name