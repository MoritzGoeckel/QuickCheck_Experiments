#!/bin/sh
pdflatex -interaction=nonstopmode doc 
biber doc
pdflatex -interaction=nonstopmode doc 