#!/usr/bin/python

import requests
import json

json_str={'sampleText':'Irans two navies were only a few years into a major reorganization, and each service was navigating through a period of considerable change. Now, nearly a decade following the reorganization, we have a better understanding of Irans ultimate intentions for there organization and clearer insight into how its navies are progressing during this time of transition. This new insight and understanding have made it even more necessary to consider and address each of Irans navies as distinct organizations with independent strategies, doctrines and missions.', 'count':'20'}
data_json = json.dumps(json_str)
ws_header = {'Content-Type': 'application/json'}
url = 'https://metatagger.dtic.mil/mauitagger/api/mauitagger/getTags'

response = requests.post(url, data=data_json, headers=ws_header)
print(response.text)
