module.exports = {
  ROOM_ID: "YourSpaceId12345\\Space Name",
  MAP_ID: "custom_entrance",
  API_KEY: "[your api key]",
  DOOR_IMAGES: {
    "open": "image url here",
    "closed": "image url here"
    "width": // width in Gather tiles (pixels / 32) of the door images
    "height": // height in Gather tiles (pixels / 32) of the door images
  },
  DOOR_POS: {
    "x": [x coor],
    "y": [y coor]
  },
  PASSWORD: "[password to door]",
  DOOR_URL: "url to wherever you're hosting the server", // note: http://localhost:3000 will NOT work, because only https is allowed in iFrames on https domains :P
}