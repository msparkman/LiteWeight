#stolen from the top answer on https://stackoverflow.com/questions/4595197/how-to-grab-the-lines-after-a-matched-line-in-python
def group_by_heading( some_source ):
    buffer = []
    for line in some_source:
        if "Day" in line:
            if buffer: yield buffer
            buffer = [ line ]
        else:
            buffer.append( line )
    yield buffer

with open("weights.txt", "r" ) as source:
	for heading_and_lines in group_by_heading( source ):
		heading = heading_and_lines[0]
		lines = heading_and_lines[1:]

		print(heading)
		for line in lines:	
			print(line)