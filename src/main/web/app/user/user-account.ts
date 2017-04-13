export interface UserAccount{
	id: number;
	username: string;
	password: string;
	e_mail: string;
	country: string;
	nick: string;
	isVerified: boolean;
	isFilled: boolean;
}