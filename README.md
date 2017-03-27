## summary
A `grep` equivalent for searching Java files.

## Completed
* search file name or file content by keyword, including files contained in zip/jar/war/ear archive

## TODO
* use arguments similar to `find`, can create logic expressions for matcher

## architecture
* file system objects are modeled by FileNode, FolderNode, ZipNode, and a special ZipEntryNode representing contents of a zip file.
* a bread-first traversing algorithm is implemented in Graph
* Visitor is used to exam each resource during traversing
* NodeRetriever is used to find next set of nodes to visit
* ResourceNodeFactory is used to create the right type of node for visiting
* Matcher is used to match or ignore resources