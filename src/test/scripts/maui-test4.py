#!/usr/bin/python

import requests
import json

json_str={'sampleText':'This report provides background information and issues for Congress on three potential new weapons that could improve the ability of Navy surface ships to defend themselves against enemy missilessolid state lasers (SSLs), the electromagnetic railgun (EMRG), and the hypervelocity projectile (HVP).1Any one of these new weapon technologies, if successfully developed and deployed, might be regarded as a game changer for defending Navy surface ships against enemy missiles. If two or three of them are successfully developed and deployed, the result might be considered not just a game changer, but a revolution.', 'count':'20'}
data_json = json.dumps(json_str)
ws_header = {'Content-Type': 'application/json'}
url = 'https://metatagger.dtic.mil/mauitagger/api/mauitagger/getTags'

response = requests.post(url, data=data_json, headers=ws_header)
print(response.text)
