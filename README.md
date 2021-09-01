# react-native-webdav

A sardine-android wrapper for react native to access files with webdav.

## IMPORTANT

- This package is only for Android apps. No plan to support ios from my side. Feel free to pull request.

- This package has only been tested for RN >=0.64.0

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
    console.log(res); //true if exists
  })
  .catch((err) => {
    console.log(err);
  });
```

### Move file

```javascript
import RNWebdav from "react-native-webdav";

//URL points to the file
RNWebdav.move(USERNAME, PASSWORD, SOURCE_URL, DESTINATION_URL, IS_OVERWRITE) //Url needs to contain the file name and extension
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

RNWebdav.download(USERNAME, PASSWORD, URL_TO_FILE, DEST_PATH_FOR_FILE) //Url and path needs to contain the file name and extension
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

RNWebdav.upload(USERNAME, PASSWORD, DEST_URL_FOR_FILE, SOURCE_PATH_TO_FILE) //Url and path needs to contain the file name and extension
  .then((res) => {
    console.log(res); //true if success
  })
  .catch((err) => {
    console.log(err);
  });
```

## License

This project is licensed under MIT
