
Youtube for EMFJson provides an EMF model and api for querying and manipulating youtube data.

# Usage
		
	YouTube service = new YouTube("emf")
		.maxResults(10);
	
	Resource resource = resourceSet.createResource(service.getURI());
	options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, YoutubePackage.eINSTANCE.getVideoResult());
			
	resource.load(options);
	
	VideoResult result = (VideoResult) resource.getContents().get(0);
	for (VideoItem item: result.getItems()) {
		// do things with video items
	}
