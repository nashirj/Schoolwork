'''
Summary:

There are two ways you can use the Google search engine: 1) using the Google Search API. 2) construct an HTTP requrest and
send it to the Google server. In this assignment, we will use the second method.  write a program that constructs a http request
with search keywords that the user provides and send a search query to the Google search engine.  Parse the result of the
search query and extract all the links in the response which uses http.

Description:

The program must prompt the user to enter a word or words of interest to perform a Google search. Then, it constructs the
http request in the form of a URL and requsts the result from the Google server. The Google server sends the HTML formatted
response in the form of binary data. The program must decode the binary data to string format and parse the HTML content and
extract the links which start with ‘http’ in the response.

The basic form of a search query is: http://www.google.com/search?q=<search words separated by +>
for example, if the user enters the search words “ucla extension”, the search query looks like:
http://www.google.com/search?q=ucal+extension (Links to an external site.)Links to an external site.

Since we are not using the Google APIs, the Google server may block your request unless it is coming from a valid user agent
(i.e. browser). Use the sample code below to form the request object. The first argument to the “Request” construtor is the
URL that you need to construct as described above.

user_agent = 'Mozilla/5.0'
headers={'User-Agent':user_agent,}
request= Request(url,None,headers)
response = urlopen(request)

For the second part of the program, define a class “MyHTMLParser” that parses the html response and extract the links that start
with ‘http’. Use the example code provided in the module presentation slides. You must use regular expression to find a matching
links that start with ‘http’.

This is an example of what the program output would look like if you search for “ucla extension” keyword:
http://www.uclaextension.edu/str/HowtoEnroll.aspx#Concurrent
http://www.ucla.edu/admission/extension-enrollment
http://webcache.googleusercontent.com/search?q=cache:OVUo66xNi78J:www.ucla.edu/admission/extension-enrollment+&cd=10&hl=en&ct=clnk&gl=us
http://www.ucla.edu/academics/continuing-education
http://webcache.googleusercontent.com/search?q=cache:5aQmeiLNRFoJ:www.ucla.edu/academics/continuing-education+&cd=11&hl=en&ct=clnk&gl=us
http://www.yelp.com/biz/ucla-extension-los-angeles-6
http://webcache.googleusercontent.com/search?q=cache:04zPJLOjhOQJ:www.yelp.com/biz/ucla-extension-los-angeles-6+&cd=12&hl=en&ct=clnk&gl=us
http://en.wikipedia.org/wiki/UCLA_Extension
http://www.facebook.com/UCLAExtensionEntertainmentStudies
http://www.facebook.com/UCLAExtensionEntertainmentStudies
http://www.google.com/shopping?hl=en&tab=wf&ei=nj7mVqu9PI--jwPx4JKADw&ved=0EKkuCAwoDA
'''

from urllib.request import urlopen, Request, urljoin
from html.parser import HTMLParser
import re

class MyHTMLParser(HTMLParser):
    'collects hyperlink URLs into a list'

    def __init__(self, url):
        'initializes parser, the url, and a list'
        HTMLParser.__init__(self)
        self.url = url
        self.links = []
        #regular expression to be used in handle_starttag
        self.pattern = re.compile("http")

    def handle_starttag(self, tag, attrs):
        'collects hyperlink URLs in their absolute format'
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    #collect HTTP URLs using regular expression
                    if(self.pattern.search(attr[1]) != None):
                        self.links.append(attr[1])
                        
    def getLinks(self):
        'returns hyperlinks URLs in their absolute format'
        return self.links



def get_search_terms():
    user_in = input('please enter your search terms: ')
    
    while(user_in == '' or user_in == '\n' or all(i == ' ' for i in user_in)):
        user_in = input('please enter your search terms: ')
    
    #get rid of leading whitespace, then replace ' ' with '+'. google doesn't do anything to format multiple interior or trailing spaces
    url_suffix = user_in.lstrip().replace(' ', '+')

    return url_suffix

def format_links(links):
    #first 24 lines are proprietary google pages i.e. youtube, mail.google
    links = links[24:]
    #this starts all links at 'http' and ends before '&' (seems to be trailing metadata)
    links = [l[l.find('http'):l.find('&')] for l in links]
    #remove suffix (search appends "+term1+term2+...+termN" suffix to certain terms)
    links = [l if (l.find('+') == -1) else l[:l.find('+')] for l in links if l != '']
    #remove duplicates - example output provided includes duplicates
    #links = list(set(links))

    return links


def main():
    url = 'http://www.google.com/search?q=' + get_search_terms()

    # < search words separated by + >
    # for example, if the user enters the search words “ucla extension”, the search query looks like:
    # http://www.google.com/search?q=ucla+extension

    #provided code to make request
    user_agent = 'Mozilla/5.0'
    headers = {'User-Agent': user_agent, }
    request = Request(url, None, headers)
    response = urlopen(request)
    
    content = response.read().decode()
    parser = MyHTMLParser(url)
    parser.feed(content)
    links = parser.getLinks()

    #do i need this?
    parser.close()

    formatted_links = format_links(links)

    for link in formatted_links:
        print(link)
    


if __name__ == '__main__':main()