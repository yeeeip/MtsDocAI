import re
from collections import defaultdict
from pdfminer.high_level import extract_pages
from pdfminer.layout import LTTextContainer

def is_normal(text):
    stripped_text = text.strip()

    if not stripped_text:
        return False

    if re.fullmatch(r"[()\d,.\-]+", stripped_text):
        return False

    if len(stripped_text.split()) == 1:
        if re.fullmatch(r"[a-zA-Zа-яА-Я0-9]+", stripped_text):
            return False
        if re.search(r"\d", stripped_text) or re.search(r"[^\w\s]", stripped_text):
            return False

    if re.search(r"\w+-$", stripped_text):
        return False

    if re.fullmatch(r"\(\d+[,.\d]*\)", stripped_text):
        return False

    if re.search(r"\d", stripped_text) and re.search(r"[a-zA-Zа-яА-Я]", stripped_text):
        return False

    if re.fullmatch(r"[^\w\s]+", stripped_text):
        return False

    return True


def parse_doc(path_to_pdf):
    pages_text = defaultdict(str)
    for page_number, page_layout in enumerate(extract_pages(path_to_pdf), start=1):
        for element in page_layout:
            if isinstance(element, LTTextContainer):
                if is_normal(element.get_text()):
                    text = re.sub(r'[\n,\\n\d,()]', '', element.get_text())
                    text = re.sub(r'\s{2,}', ' ', text)
                    pages_text[page_number] += text

    return pages_text