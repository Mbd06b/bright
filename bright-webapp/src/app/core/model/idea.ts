import { IdeaInterface } from './idea.interface';
import { UserLinkView } from './userlinkview';

export class Idea implements IdeaInterface {

  id: number;
  title: string;
  subtitle: string;
  story: string;
  upVotes: number;
  downVotes: number;

  actingEntityId: number;
  action: string;
  users: UserLinkView[];
}
