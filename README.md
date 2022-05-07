# file-upload-download

## upload
> use MultipartFile, StringUtils libraries. and Postman api<br/>
```java

    @PostMapping("/upload")
    public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
        fileService.store(file);
    }
    
    @PostMapping("/multi-upload")
    public void fileUpload(@RequestParam("file") MultipartFile[] files) throws IOException{
        for(MultipartFile file:files){
            fileService.store(file);
        }
    }

```

### DB setting 
 ![image](https://user-images.githubusercontent.com/64727012/161433324-b2606f5a-0817-4791-8714-b63a6ab2d03f.png)


## download
> return type is byte[], and add CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"" in header.
```java
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> fileDownload(@PathVariable Long id){
        
        File file = fileService.getFile(id);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getData());
    }

```
