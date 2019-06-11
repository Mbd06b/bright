import { Role } from './role.enum';
import { IdeaLinkView } from './idealinkview';

export interface UserInterface {
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

  ideas: IdeaLinkView[];

}
