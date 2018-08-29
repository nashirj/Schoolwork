

from urllib.request import urlopen, Request, urljoin


def checkValidity(content, content_lst):
  valid = bool()
  if ('"status" : "NOT_FOUND"') in content:
    valid = False
  elif ('"status" : "ZERO_RESULTS"') in content:
    valid = False
  elif ('"status" : "MAX_ROUTE_LENGTH_EXCEEDED"') in content:
    valid = False
  else:
    print("valid search")
    value = content_lst[9][10:]
    print(value)
    return

  if not valid:
    start_ind = len('"destination_addresses" : [ "')
    if content_lst[1][start_ind] == '"':
      raise ValueError(self.origin + ' is not a valid starting point')
    end_ind = content_lst[1].find(',')
    start = content_lst[1][start_ind:end_ind] #need to extract this from json
    start_ind = len('"origin_addresses" : [ "')
    if content_lst[2][start_ind] == '"':
      raise ValueError(self.origin + ' is not a valid starting point')
    end_ind = content_lst[2].find(',')
    end = content_lst[2][start_ind:end_ind] #need to extract this from json
    print("distance between " + start + " and " + end + " not found")
    #raise ValueError("distance between " + start + " and " + end + " not found")



'''
Create a class called Tour.  An instance of this class is to be instantiated with two US cities, and is used to fetch information
from the web.
'''
class Tour:
  '''
  1. __init__  The constructor takes two strings as arguments, each giving a city name and state abbreviation, indicating the origin
  and destination.  For example: Tour(“New York, NY”, “Los Angeles, CA”)represents a tour that starts in New York city and ends in
  Los Angeles.
  '''
  def __init__(self, origin, destination):
    self.origin = origin
    self.destination = destination

  '''
  2. distance  This method takes a single (optional) argument indicating a mode – one of the strings ‘driving’ (default), ‘biking, or
  ‘walking’.  It returns the total distance (in meters) covered by the tour for the indicated mode.  This method is where you will use
  urllib functions to get data from the web to find the distances between two locations in the tour and calculate the total distance.
  If a response does not contain a distance value, the method should raise a ValueError exception.
  '''
  def distance(self, mode=None):
    if mode is None:
      self.mode = 'driving'
    else:
      self.mode = mode
    
    self.origin = self.origin.replace(' ', '+')
    self.destination = self.destination.replace(' ', '+')
    self.mode = 'biking' # or 'biking' or 'walking'
    if self.mode != 'driving' and self.mode != 'biking' and self.mode != 'walking':
      print("Invalid mode. valid modes are 'driving', 'biking', and 'walking'")
      exit()

    url = "http://maps.googleapis.com/maps/api/distancematrix/json?origins="
    url += self.origin
    url += "&destinations="
    url += self.destination
    url += "&mode="
    url += self.mode
    url += "&sensor=false" #tells the server that the application does not use a GPS locator
    print(url)

    #provided code to make request
    user_agent = 'Mozilla/5.0'
    headers = {'User-Agent': user_agent, }
    request = Request(url, None, headers)
    response = urlopen(request)
  
    content = response.read().decode()

    print(content)

    content_lst = content.split("\n")
    content_lst = [c.strip() for c in content_lst]

    for i in content_lst:
      print(i)
    value = str()
    checkValidity(content, content_lst)


'''
Create a class called TourGui. An instance of this class is to be instantiated in the main.

1. __init__
The constructor doesn’t take any arguments. The constructor creates two frames in the window, a top frame and bottom frame. The top
frame contains a  label and an entry widget for the following fields: origin, destination, and mode. The bottom frame contains a label
and text widget for Distance and a button widget for Get Distance.
see prompt for how it should look

2. onClick
This method is the event handler for the Get Distance Button. When the button is clicked, the origin, destination and mode fields are
read, the query is made and the distance between the origin and the destination is displayed.
If the user enters an invalid mode, a message box shows up indicating invalid mode was entered.
If the distance was not found between the origin and the destination, a message box shows up indicating the distance was not found:
'''

class TourGui:
  def __init__(self):
    print("new gui")

  def onClick(self):
    print("clicked")




def main():
  #get parameters
  t = Tour("New York, NY", "Paris France")
  t.distance()


  
  
  

  

if __name__ == "__main__":main()
