from PIL import Image, ImageFilter
from matplotlib.pyplot import imshow

img = Image.open('1.png')

w, h = img.size

print('original image size: %s %s' % (w, h))

img2 = img.filter(ImageFilter.BLUR)
img2.save('blur.jpg', 'jpeg')
