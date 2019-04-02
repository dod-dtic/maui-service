#!/usr/bin/python

import requests
import json

json_str={'sampleText':'The objective of this seedling project is to overcome these limitations by developing a new theoretical framework for design under uncertainty (DUU), based on new stochastic approaches for risk-averse design and optimization of engineering systems under uncertainty.', 'count':'20'}
data_json = json.dumps(json_str)
ws_header = {'Content-Type': 'application/json'}
url = 'https://metatagger.dtic.mil/mauitagger/api/mauitagger/getTags'

response = requests.post(url, data=data_json, headers=ws_header)
print(response.text)
