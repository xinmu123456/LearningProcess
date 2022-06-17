from PIL import Image
import numpy as np

im = Image.open(
    'E:\Sync\work\img\\vsc.png')

im = np.array(im)
print(im.shape)
print(im[50, 50])

im_r = im[:, :, 0]
Image.fromarray(im_r).show()
