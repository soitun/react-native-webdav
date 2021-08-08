# react-native-webdav

A sardine-android wrapper for react native to access files with webdav.

## IMPORTANT

- This package is only for Android apps. Since I don't know a thing about Swift or Object-C, this package has no plan to support ios from my side. Feel free to pull request.

- This package has only been tested for RN 0.64.0

- This package doesn't accept feature requests for now.

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
    console.log(res); //folders and files in a array sequelized to string, eg: [/dav/, /dav/KoodoReader1/, /dav/KoodoReader/, /dav/KoodoReader2/]
  })
  .catch((err) => {
    console.log(err);
  });
```

### Check if file or folder exsits

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the folder or file
RNWebdav.exsits(USERNAME, PASSWORD, URL)
  .then((res) => {
    console.log(res); //true if success
  })
  .catch((err) => {
    console.log(err);
  });
```

### Move file

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the file
RNWebdav.move(USERNAME, PASSWORD, SOURCE_URL, DESTINATION_URL) //Url needs to contain the file name and extension
  .then((res) => {
    console.log(res); //true if success
  })
  .catch((err) => {
    console.log(err);
  });
```

### Copy file

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the file
RNWebdav.copy(USERNAME, PASSWORD, SOURCE_URL, DESTINATION_URL, IS_OVERWRITE) //Url needs to contain the file name and extension
  .then((res) => {
    console.log(res); //true if success
  })
  .catch((err) => {
    console.log(err);
  });
```

### Create folder

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

### Download file

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

### Upload file

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
