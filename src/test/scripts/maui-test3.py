#!/usr/bin/python

import requests
import json

json_str={'sampleText':'testing the machine learning thing', 'count':'20'}
data_json = json.dumps(json_str)
ws_header = {'Content-Type': 'application/json'}
url = 'https://metatagger.dtic.mil/mauitagger/api/mauitagger/getTags'

response = requests.post(url, data=data_json, headers=ws_header)
print(response.text)
