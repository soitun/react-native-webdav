declare module 'react-native-webdav' {

  export default class RNWebdav {
    list: (string:username, string:password, string:url)=>Promise<string>
    createDirectory: (string:username, string:password, string:url)=>Promise<boolean>
    download: (string:username, string:password, string:url, string: dest)=>Promise<boolean>
    upload: (string:username, string:password, string:url, string: source)=>Promise<boolean>
  }
}