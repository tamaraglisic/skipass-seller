import { Policy } from "./Policy";
import { Tickets } from "./Tickets";

export interface PurchasedPolicy {
    policy?: Policy;
    tickets?: Tickets;
    used?: boolean;
    description?: string;
    usingStart?: Date;
    usingEnd?: Date;
}