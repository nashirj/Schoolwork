'''
from urllib.request import urlopen
response = urlopen('http://www.w3c.org/Consortium/facts.html')
print(type(response))
#<class 'http.client.HTTPResponse'>
response.geturl()
#'http://www.w3.org/Consortium/facts.html'
for header in response.getheaders():
	print(header)

#('Date', 'Mon, 23 Apr 2012 01:25:20 GMT')
#('Server', 'Apache/2')
#...
#('Content-Type', 'text/html; charset=utf-8')
html = response.read()
print(type(html))
#<class 'bytes'>
html = html.decode()
print(type(html))
#<class 'str'>
print(html)
#'<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN”
#...
#</div></body></html>\n'
'''
from urllib.request import urlopen
def news(url, topics):
    '''counts in resource with URL url the frequency
       of each topic in list topics'''

    response = urlopen(url)
    html = response.read()
    content = html.decode().lower()
    for topic in topics:
        n = content.count(topic)
        print('{} appears {} times.'.format(topic,n))


news('http://bbc.co.uk',['trump','israel','education'])