export function list(string:username, string:password, string:url):Promise<string>
export function  createDirectory (string:username, string:password, string:url):Promise<boolean>
export function  move (string:username, string:password, string:sourceUrl, string: destUrl, boolean: isOverwrite):Promise<boolean>
export function  copy (string:username, string:password, string:sourceUrl, string: destUrl, boolean: isOverwrite):Promise<boolean>
export function  exsits (string:username, string:password, string:url):Promise<boolean>
export function  download(string:username, string:password, string:url, string: dest):Promise<boolean>
export function  upload(string:username, string:password, string:url, string: source):Promise<boolean>
export function sampleMethod(string: stringArgument, number: numberArgument, any :callback)