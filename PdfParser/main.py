from os import listdir
from os.path import isfile, join

import requests

from pdf_text_parser import parse_doc

data_folder = 'data_pdf'
files = [f for f in listdir(data_folder) if isfile(join(data_folder, f))]

for file_name in files:
    print('Processing: ', file_name)
    pages_dict = parse_doc(data_folder + '/' + file_name)
    texts = list(pages_dict.values())
    batches = [texts[i:i + 5] for i in range(0, len(texts), 5)]
    if len(batches) > 0:
        for batch in batches:
            requests.post('http://localhost:8080/api/v1/embed/batch',
                          data={'texts': batch},
                          headers={'Accept': 'application/json'}
                          )
