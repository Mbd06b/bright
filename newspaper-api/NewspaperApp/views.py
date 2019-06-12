'''
Created on Mar 20, 2019

@author: matthew.b.dowell
'''

from django.shortcuts import render
from django.http import Http404
from rest_framework.views import APIView
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework import status
from django.http import JsonResponse
from django.core import serializers
from django.conf import settings
import json
import nltk
nltk.download('punkt')

from newspaper import Article



# Create your views here.
@api_view(["POST"])
def ProcessInput(hrefUrl):
    
     
    try:
    
        article = Article(hrefUrl.body.decode())
        article.download()
        article.parse()
        article.nlp()
        
        articleJson= json.loads('{ "article" : {' \
                                +   ' "title" :'        + json.dumps(article.title)        + ',' \
                                +   ' "authors" : '     + json.dumps(article.authors)      + ',' \
                                +   ' "publishDate" : ' + json.dumps(article.publish_date) + ',' \
                                +   ' "topImage" : '    + json.dumps(article.top_image)    + ',' \
                                +   ' "movies" : '      + json.dumps(article.movies)       + ',' \
                                +   ' "keywords":'      + json.dumps(article.keywords)     + ',' \
                                +   ' "summary" : '     + json.dumps(article.summary)      + ',' \
                                +   ' "text" : '        + json.dumps(article.text)         + ' ' \
                                +   '}}')

        return JsonResponse(articleJson,safe=False)
    except ValueError as e:
        return Response(e.args[0],status.HTTP_400_BAD_REQUEST)