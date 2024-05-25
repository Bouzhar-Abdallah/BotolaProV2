export interface Token{
    exp: number;
    iat: number;
    iss: string;
    scope: string;
    sub: string;
}