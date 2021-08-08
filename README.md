# react-native-webdav

A sardine-android wrapper for react native to access files with webdav.

## IMPORTANT

This package is only for Android apps. Since I don't know a thing about Swift or Object-C, and I'm not intended to, This package has no plan to support ios in the future.

This package has only been tested for RN 0.64.0

This package don't accept feature requests, I made this package solely for my personal project.

## Usage (Android)

```
npm install react-native-webdav --save
```

## Examples

### List files and folders

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the folder
RNWebdav.list(USERNAME, PASSWORD, URL)
  .then((res) => {
    console.log(res); //folders and files in a array sequelized to string
  })
  .catch((err) => {
    console.log(err);
  });
```

### Create folders

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the folder
RNWebdav.createDirectory(USERNAME, PASSWORD, URL)
  .then((res) => {
    console.log(res); //true if success
  })
  .catch((err) => {
    console.log(err);
  });
```

### Download files

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the file
RNWebdav.download(USERNAME, PASSWORD, URL, PATH_TO_YOUR_FILE) //Url and path needs to contain the file name and extension
  .then((res) => {
    console.log(res); //true if success
  })
  .catch((err) => {
    console.log(err);
  });
```

### Upload files

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the file
RNWebdav.upload(USERNAME, PASSWORD, URL, PATH_YOU_UPLOAD_TO) //Url and path needs to contain the file name and extension
  .then((res) => {
    console.log(res); //true if success
  })
  .catch((err) => {
    console.log(err);
  });
```

## License

This project is licensed under MIT
