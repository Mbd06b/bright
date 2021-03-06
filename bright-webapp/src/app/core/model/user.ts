import { UserInterface } from './user.interface';
import { Role } from './role.enum';
import { IdeaLinkView } from './idealinkview';
import { Idea } from './idea';

export class User implements UserInterface {

  accessTokens: User[];

  id: number;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  title: string;
  aboutMe: string;
  userImgUrl: string;
  avatarUrl: string;

  token: string;
  role: string;

  ideaLinks: IdeaLinkView[];
  ideas: Idea[];

  constructor() {}

}


