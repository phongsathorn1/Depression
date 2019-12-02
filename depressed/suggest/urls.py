from suggest import views
from django.urls import path, include

urlpatterns = [
    path('suggestion_list', views.SuggestionList.as_view()),
    path('suggestion_list/<int:id>', views.SuggestionDetail.as_view()),
    path('suggestion/<int:total_score>', views.Advice.as_view()),
]
