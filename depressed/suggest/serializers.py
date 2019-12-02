from rest_framework import serializers
from suggest.models import Suggestion


class SuggestionSerializer(serializers.ModelSerializer):
    class Meta:
        model = Suggestion
        fields = '__all__'


class GiveSuggestionSerializer(serializers.ModelSerializer):
    class Meta:
        model: Suggestion
        fields = ['total_score', 'depressed_level', 'advice']
