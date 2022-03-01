import requests
from flask import Flask, render_template, jsonify

application = Flask(__name__)

Sound_Emitter = {
    "orientation": 0,
    "scale": 1,
    "templateId": "SoundEmitterRooftop - IT-TYjQjljBEo8cuuTKFN",
    "_name": "Sound Emitter (Rooftop) ",
    "offsetY": 3.600008408228632,
    "type": 0,
    "height": 3,
    "highlighted": "https://cdn.gather.town/v0/b/gather-town.appspot.com/o/internal-dashboard-upload%2FBJktsgEoYRHKEgtU?alt=media&token=06c38d5d-3c2b-4b24-bba9-4af5ae45f1f6",
    "width": 2,
    "normal": "https://cdn.gather.town/v0/b/gather-town.appspot.com/o/internal-dashboard-upload%2FA5P7v3cPoZf1Glre?alt=media&token=af149822-3939-4126-b11d-c73cbe09ec91",
    "offsetX": 12.279190095536705,
    "y": 28,
    "color": "#9badb7",
    "sound": {
        "volume": 0.5, #📌
        "loop": True, #📌
        "src": "https://docs.google.com/uc?export=open&id=1Yh-5SNSChSOAOTZCwWzOuHdUgRNabRce",
        "maxDistance": 1000 #📌
    },
    "properties": {},#📌
    "x": 51,#📌
    "_tags": [
        "sound",
        "sound/ambience"
    ],
    "objectPlacerId": "1vHPMnxnjgX3wr6qvBvUHTEERl82",
    "id": "SoundEmitterRooftop - IT-TYjQjljBEo8cuuTKFN_f11fad1f-aa0f-463a-a390-c59c0ea1f196"
}


@application.route('/')
def index():
    return render_template('index.html')


@application.route('/test')
def get_laws():
    space_id = '8O0wuN4ITdtX280U\\castle'
    map_id = 'castle'
    api_key = 'JAqmFCPJMe1EJSV6'
    get_url = f'https://gather.town/api/getMap?spaceId={space_id}&mapId={map_id}&apiKey={api_key}'
    data = requests.get(get_url).json()
    print(get_url)
    print(data['objects'][1]['x'])
    data['objects'][1]['x'] = 40
    data['objects'].append(Sound_Emitter)
    set_url = f'https://gather.town/api/setMap'
    # ?spaceId = {space_id} & mapId = {map_id} & apiKey = {api_key}?mapContent = {data}
    requests.post(set_url, json={'spaceId': space_id, 'mapId': map_id, 'apiKey': api_key, 'mapContent': data})

    return jsonify(data['objects'])


if __name__ == '__main__':
    application.run('0.0.0.0', port=5000, debug=True)
