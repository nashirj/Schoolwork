from tkinter import *
from tkinter.messagebox import showinfo

from urllib.request import urlopen, Request, urljoin


def checkValidity(content, content_lst):
  valid = bool()
  if ('"status" : "NOT_FOUND"') in content:
    return False
  elif ('"status" : "ZERO_RESULTS"') in content:
    return False
  elif ('"status" : "MAX_ROUTE_LENGTH_EXCEEDED"') in content:
    return False
  else:
    return True



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
  def distance(self, mode):
    if mode == '':
      self.mode = 'driving'
    else:
      self.mode = mode
    
    unformatted_origin = self.origin[:self.origin.find(',')]
    unformatted_destination = self.destination[:self.destination.find(',')]
    
    self.origin = self.origin.replace(' ', '+')
    self.origin = self.origin.replace(',', '')
    self.destination = self.destination.replace(' ', '+')
    self.destination = self.destination.replace(',', '')

    url = "http://maps.googleapis.com/maps/api/distancematrix/json?origins="
    url += self.origin
    url += "&destinations="
    url += self.destination
    url += "&mode="
    url += self.mode
    url += "&sensor=false" #tells the server that the application does not use a GPS locator
    
    #provided code to make request
    user_agent = 'Mozilla/5.0'
    headers = {'User-Agent': user_agent, }
    request = Request(url, None, headers)
    response = urlopen(request)
  
    content = response.read().decode()

    content_lst = content.split("\n")
    content_lst = [c.strip() for c in content_lst]

    value = checkValidity(content, content_lst)
    if value:
      distance = content_lst[9][10:]
      print(distance)
      return distance
    else:
      showinfo(message="distance between " + unformatted_origin + " and " + unformatted_destination + " not found")
      raise ValueError("distance between " + unformatted_origin + " and " + unformatted_destination + " not found")
      return False





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

class TourGui(Frame):
  def __init__(self):
    root = Tk()

    root.title('Tour')
  
    Frame.__init__(self, root)
    self.pack(side=TOP)

    label1 = Label(self, text='Origin')
    label1.grid(row=0, column=0)

    self.OriginEntry = Entry(self)
    self.OriginEntry.grid(row=1, column=0)

    label2 = Label(self, text='Destination')
    label2.grid(row=2, column=0)

    self.DestinationEntry = Entry(self)
    self.DestinationEntry.grid(row=3, column=0)

    label3 = Label(self, text='Mode')
    label3.grid(row=4, column=0)

    self.ModeEntry = Entry(self)
    self.ModeEntry.grid(row=5, column=0)

    space1 = Label(self, text='')
    space1.grid(row=6, column=0)

    space2 = Label(self, text='')
    space2.grid(row=7, column=0)

    label4 = Label(self, text='Distance (m)')
    label4.grid(row=8, column=0)

    self.display_text = StringVar()
    self.Distance = Entry(self, textvariable=self.display_text)
    self.Distance.grid(row=9, columnspan=3)

    button = Button(self, text='Get Distance', command=self.onClick)
    button.grid(row=10, column=0, columnspan=2)

    root.mainloop()

  def onClick(self):
    origin = self.OriginEntry.get().strip()
    destination = self.DestinationEntry.get().strip()
    mode = self.ModeEntry.get().strip()

    if origin == '' or destination == '':
      showinfo(message="please input an origin and a destination")
      return

    if mode != 'driving' and mode != 'biking' and mode != 'walking' and mode != '':
      showinfo(message="Invalid mode. valid modes are 'driving', 'biking', and 'walking'")
      return

    tour = Tour(origin, destination)
    distance = tour.distance(mode)
    if distance == False:
      return
    showinfo(message=distance)

    self.display_text.set(distance)



if __name__ == '__main__':
  tGui = TourGui()