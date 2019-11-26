from django.views import View
from rest_framework import generics
from django.shortcuts import get_object_or_404
from django.http import JsonResponse
from suggest.models import Suggestion
from suggest.serializers import SuggestionSerializer, GiveSuggestionSerializer


class SuggestionList(generics.ListCreateAPIView):
    queryset = Suggestion.objects.all()
    serializer_class = SuggestionSerializer


class SuggestionDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Suggestion.objects.all()
    lookup_field = 'id'
    serializer_class = SuggestionSerializer


# class Advice(generics.RetrieveUpdateDestroyAPIView):
#     queryset = Suggestion.objects.all()
#     lookup_field = 'total_score'
#     def get_queryset(self):
#         return Suggestion.objects.get(pk=3).depressed_level
#     serializer_class = GiveSuggestionSerializer

class Advice(View):
    def get(self, request, total_score):
        if 0 <= total_score <= 4:
            sgt = get_object_or_404(Suggestion, id=3)
            serializer = SuggestionSerializer(sgt)
            return JsonResponse(serializer.data)
        elif 5 <= total_score <= 9:
            sgt = get_object_or_404(Suggestion, id=4)
            serializer = SuggestionSerializer(sgt)
            return JsonResponse(serializer.data)
        elif 10 <= total_score <= 14:
            sgt = get_object_or_404(Suggestion, id=5)
            serializer = SuggestionSerializer(sgt)
            return JsonResponse(serializer.data)
        elif 15 <= total_score <= 19:
            sgt = get_object_or_404(Suggestion, id=6)
            serializer = SuggestionSerializer(sgt)
            return JsonResponse(serializer.data)
        elif 20 <= total_score <= 27:
            sgt = get_object_or_404(Suggestion, id=7)
            serializer = SuggestionSerializer(sgt)
            return JsonResponse(serializer.data)
        else:
            return JsonResponse({'detail': 'ERROR DATA NOT FOUND'})
